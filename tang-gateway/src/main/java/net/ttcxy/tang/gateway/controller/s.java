package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.io.FileUtil;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.*;

public class s {


    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\ppt_mp4");


        File[] fs =  file.listFiles();
        assert fs != null;
        Set<String> paths = new TreeSet<>((o1, o2) -> {
            Integer substring1 = Integer.parseInt(o1.substring(o1.lastIndexOf("\\") + 1, o1.lastIndexOf(".")));
            Integer substring2 = Integer.parseInt(o2.substring(o2.lastIndexOf("\\") + 1, o2.lastIndexOf(".")));

            return substring1.compareTo(substring2);//降序排列
        });
        for (File fi : fs){
            paths.add(fi.getPath());
        }



        for (String p : paths){
            System.out.println(p);
        }
        mergeVideo(new ArrayList<>(paths),new File("C:\\Users\\Administrator\\Desktop\\999.mp4"));


    }


    /**
     * 合并视频
     *
     * @param videoList: 所有视频地址集合
     * @param mergeVideoFile: 目标文件
     * @return
     */
    public static String mergeVideo(List<String> videoList, File mergeVideoFile) {
        FileOutputStream fos = null;
        FileChannel fc = null;
        try {
            List<Movie> sourceMovies = new ArrayList<>();
            for (String video : videoList) {
                sourceMovies.add(MovieCreator.build(video));
            }

            List<Track> videoTracks = new LinkedList<>();
            List<Track> audioTracks = new LinkedList<>();

            for (Movie movie : sourceMovies) {
                for (Track track : movie.getTracks()) {
                    if ("soun".equals(track.getHandler())) {
                        audioTracks.add(track);
                    }

                    if ("vide".equals(track.getHandler())) {
                        videoTracks.add(track);
                    }
                }
            }

            Movie mergeMovie = new Movie();
            if (audioTracks.size() > 0) {
                mergeMovie.addTrack(new AppendTrack(audioTracks.toArray(new Track[audioTracks.size()])));
            }

            if (videoTracks.size() > 0) {
                mergeMovie.addTrack(new AppendTrack(videoTracks.toArray(new Track[videoTracks.size()])));
            }

            Container out = new DefaultMp4Builder().build(mergeMovie);
            fos = new FileOutputStream(mergeVideoFile);
            fc = fos.getChannel();
            out.writeContainer(fc);
            fc.close();
            fos.close();
            return mergeVideoFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fc != null) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    /**
     * 剪切视频
     * @param srcVideoPath
     * @param dstVideoPath
     * @param times
     * @throws IOException
     */
    public static void cutVideo(String srcVideoPath, String dstVideoPath, double[] times) throws IOException {
        int dstVideoNumber = times.length / 2;
        String[] dstVideoPathes = new String[dstVideoNumber];
        for (int i = 0; i < dstVideoNumber; i++) {
            dstVideoPathes[i] = dstVideoPath + "cutOutput-" + i + ".mp4";
        }
        int timesCount = 0;

        for (int idst = 0; idst < dstVideoPathes.length; idst++) {
            //Movie movie = new MovieCreator().build(new RandomAccessFile("/home/sannies/suckerpunch-distantplanet_h1080p/suckerpunch-distantplanet_h1080p.mov", "r").getChannel());
            Movie movie = MovieCreator.build(srcVideoPath);

            List<Track> tracks = movie.getTracks();
            movie.setTracks(new LinkedList<Track>());
            // remove all tracks we will create new tracks from the old


            double startTime1 = times[timesCount];
            double endTime1 = times[timesCount + 1];
            timesCount = timesCount + 2;

            boolean timeCorrected = false;

            // Here we try to find a track that has sync samples. Since we can only start decoding
            // at such a sample we SHOULD make sure that the start of the new fragment is exactly
            // such a frame
            for (Track track : tracks) {
                if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                    if (timeCorrected) {
                        // This exception here could be a false positive in case we have multiple tracks
                        // with sync samples at exactly the same positions. E.g. a single movie containing
                        // multiple qualities of the same video (Microsoft Smooth Streaming file)

                        throw new RuntimeException("The startTime has already been corrected by another track with SyncSample. Not Supported.");
                    }
                    startTime1 = correctTimeToSyncSample(track, startTime1, false);
                    endTime1 = correctTimeToSyncSample(track, endTime1, true);

                    timeCorrected = true;
                }
            }

            for (Track track : tracks) {
                long currentSample = 0;
                double currentTime = 0;
                double lastTime = -1;
                long startSample1 = -1;
                long endSample1 = -1;


                for (int i = 0; i < track.getSampleDurations().length; i++) {
                    long delta = track.getSampleDurations()[i];


                    if (currentTime > lastTime && currentTime <= startTime1) {
                        // current sample is still before the new starttime
                        startSample1 = currentSample;
                    }
                    if (currentTime > lastTime && currentTime <= endTime1) {
                        // current sample is after the new start time and still before the new endtime
                        endSample1 = currentSample;
                    }

                    lastTime = currentTime;
                    currentTime += (double) delta / (double) track.getTrackMetaData().getTimescale();
                    currentSample++;
                }
                //movie.addTrack(new AppendTrack(new ClippedTrack(track, startSample1, endSample1), new ClippedTrack(track, startSample2, endSample2)));
                movie.addTrack(new CroppedTrack(track, startSample1, endSample1));
            }
            long start1 = System.currentTimeMillis();
            Container out = new DefaultMp4Builder().build(movie);
            long start2 = System.currentTimeMillis();
            FileOutputStream fos = new FileOutputStream(String.format(dstVideoPathes[idst]));
            FileChannel fc = fos.getChannel();
            out.writeContainer(fc);

            fc.close();
            fos.close();
            long start3 = System.currentTimeMillis();

        }
    }

    private static double correctTimeToSyncSample(Track track, double cutHere, boolean next) {
        double[] timeOfSyncSamples = new double[track.getSyncSamples().length];
        long currentSample = 0;
        double currentTime = 0;
        for (int i = 0; i < track.getSampleDurations().length; i++) {
            long delta = track.getSampleDurations()[i];

            if (Arrays.binarySearch(track.getSyncSamples(), currentSample + 1) >= 0) {
                // samples always start with 1 but we start with zero therefore +1
                timeOfSyncSamples[Arrays.binarySearch(track.getSyncSamples(), currentSample + 1)] = currentTime;
            }
            currentTime += (double) delta / (double) track.getTrackMetaData().getTimescale();
            currentSample++;

        }
        double previous = 0;
        for (double timeOfSyncSample : timeOfSyncSamples) {
            if (timeOfSyncSample > cutHere) {
                if (next) {
                    return timeOfSyncSample;
                } else {
                    return previous;
                }
            }
            previous = timeOfSyncSample;
        }
        return timeOfSyncSamples[timeOfSyncSamples.length - 1];
    }

}