package io.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @author chen_wj
 * @Description:
 * @date 2018/1/27
 * @Description:
 * @modifier
 */
public class FileChannelAndBuffer {


	/**
	 * @Description: 使用FileChannel读取数据到buffer
	 *
	 * @author chen_wj 
	 * @date 2018/1/27
	 *
	 */
	@Test
	public void readBufferByFileChannel() throws IOException {

		RandomAccessFile ranfile = new RandomAccessFile("/Users/peter/Desktop/mrtweb.log","rw");

		FileChannel inChannel = ranfile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(1024);

		int bytesRead = inChannel.read(buf);
		while(bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();

			while(buf.hasRemaining()) {
				System.out.print((char)buf.get());
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		ranfile.close();

	}

	/**
	 * Buffer
	 */
	@Test
	public void bufferInfo() throws IOException {

		RandomAccessFile ranfile = new RandomAccessFile("/Users/peter/Desktop/mrtweb.log","rw");

		FileChannel inChannel = ranfile.getChannel();


		/**types of buffer : ByteBuffer,MappedByteBuffer,CharBuffer,DoubleBuffer,FloatBuffer,IntBuffer,LongBuffer,ShortBuffer
		 * allocate()分配buffer大小
		 */
		ByteBuffer bbuf = ByteBuffer.allocate(24);
		ByteBuffer mbuf = MappedByteBuffer.allocate(48);
		CharBuffer cbuf = CharBuffer.allocate(1024);
		IntBuffer intBuffer = IntBuffer.allocate(1024);

		/**
		 * 三个重要变量
		 * capacity：容量
		 * position：位置
		 * limit:能读/写的量
		 */

		/**
		 * 向buffer中写数据2种方式
		 * 从Channel写到Buffe
		 * 通过Buffer的put()方法写到Buffer里
		 */
		int bytesRead = inChannel.read(bbuf);
		intBuffer.put(127);

		/**
		 * 从buffer中读数据2种方式
		 */
		//从Buffer读取数据到Channel
		int bytesWritten = inChannel.write(bbuf);
		//使用get()方法从Buffer中读取数据
		byte abype = bbuf.get();

		/**
		 * rewind()方法
		 * 将position设回0，所以你可以重读Buffer中的所有数据,limit保持不变，仍然表示能从Buffer中读取多少个元素（byte、char等）。
		 */
		bbuf.rewind();

		/**
		 * clear()与compact()方法
		 * clear清空buffer
		 * 与compact 清掉已读buffer 未读数据拷贝到起始处 position移动到未读数据末尾
		 */
		bbuf.clear();
		bbuf.reset();

		/**
		 * 设置标记位，回到标记位
		 */
		bbuf.mark();
		bbuf.reset();
	}

	/**
	 * Scatter/Gather
	 * 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
	 * 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
	 */
	@Test
	public void Scatter_Gather() throws IOException {

		RandomAccessFile rfile = new RandomAccessFile("","rw");

		FileChannel channel = rfile.getChannel();

		ByteBuffer header = ByteBuffer.allocate(128);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] bufferArr = {header, body};

		//Scattering Reads
		channel.read(bufferArr);

		//Gathering Writes
		channel.write(bufferArr);
	}



}
