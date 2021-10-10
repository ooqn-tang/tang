package net.ttcxy.tang.portal.service;

public interface DtsLaokeService {

    int insert(String authorId, String type , String text);

    int delete(String id);

    void loadList();
}
