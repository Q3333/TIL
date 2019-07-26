package NIO;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class Buffer_3 {

	public static void main(String[] args) {
		///■  다이렉트 버퍼 용량 확인 예제

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
		System.out.println("byte 저장 용량: " + byteBuffer.capacity());
		 
		CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();
		System.out.println("char 저장 용량: " + charBuffer.capacity());
		        
		IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
		System.out.println("int 저장 용량: " + intBuffer.capacity());
		
		
		///	■  컴퓨터의 기본 바이트 해석 순서 예제
		
		System.out.println("운영체제: " + System.getProperty("os.name"));
        System.out.println("네이티브의 바이트 해석 순서: " + ByteOrder.nativeOrder());
        
        
        
        ///■  Buffer의 위치 속성값 예제
        System.out.println("[7바이트 크기로 버퍼 생성]"); 
        ByteBuffer buffer = ByteBuffer.allocateDirect(7);
        printState(buffer);
        buffer.put((byte) 10);
        buffer.put((byte) 11);
        System.out.println("[2바이트 저장후]");
        printState(buffer); 
        buffer.put((byte) 12);
        buffer.put((byte) 13);
        buffer.put((byte) 14);
        System.out.println("[3바이트 저장후]");
        printState(buffer); 
        buffer.flip();
        System.out.println("[filp 실행후]");
        printState(buffer);

        buffer.get(new byte[3]);
        System.out.println("[3바이트 읽은후]");
        printState(buffer);      
        
        buffer.mark();
        System.out.println("[현재 위치 mark 해놓음");
         
        buffer.get(new byte[2]);
        System.out.println("[2바이트 읽은 후]");
        printState(buffer);
         
        buffer.reset();
        System.out.println("[position 을 마크 위치로 옮김]");
        printState(buffer);
         
        buffer.rewind();
        System.out.println("[rewind 실행 후]");
        printState(buffer);
         
        buffer.clear();
        System.out.println("[clear 실행 후]");
        printState(buffer);
       

	}

	public static void printState(ByteBuffer buffer) {
		
		 System.out.print("\tposition: " + buffer.position() + ", ");
		 System.out.print("\tlimit: " + buffer.limit() + ", ");
		 System.out.println("\tcapacity: " + buffer.capacity());
    } 
	



}
