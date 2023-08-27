
/**
 * 用于将 dist/index.html 复制为 dist/404.html ,y用于 github pages 404 页面 也进入
 */
const fs = require('fs');
const path = require('path');


const rootDirectoryFromDirname = path.resolve(__dirname, '..');
const sourceFilePath = rootDirectoryFromDirname + '/dist/index.html';
const targetFilePath = rootDirectoryFromDirname + '/dist/404.html';

// 使用 fs.readFile 读取源文件
fs.readFile(sourceFilePath, (err, data) => {
  if (err) {
    console.error('Error reading source file:', err);
    return;
  }

  // 使用 fs.writeFile 将读取到的数据写入目标文件
  fs.writeFile(targetFilePath, data, (err) => {
    if (err) {
      console.error('Error writing target file:', err);
      return;
    }
    console.log('File copied successfully!');
  });
});