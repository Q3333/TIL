package FileIO.lab.java;
import java.io.File;

public class HardDriveCheck {
	public static void main(String arg[]){        
        String drive;
        double totalSpace, usedSpace, freeSpace, usableSpace;        
        File[] roots = File.listRoots();    // 하드디스크의 루트 드라이버들을 배열로 반환한다
        for(File root : roots){            
	drive = root.getAbsolutePath();     // 루트 드라이버의 절대 경로       
	totalSpace = root.getTotalSpace() / Math.pow(1024, 3);   // 하드디스크 전체 용량
	usableSpace = root.getUsableSpace() / Math.pow(1024,3);   // 사용가능한 디스크 용량
             freeSpace = root.getFreeSpace() / Math.pow(1024,3);  // 여유 디스크 용량            
            usedSpace = totalSpace - usableSpace;         // 사용한 디스크 용량
            System.out.println("하드 디스크 드라이버 : " + drive);
            System.out.println("총 디스크 용량 : " + totalSpace + "GB");
            System.out.println("사용 가능한 디스크 용량 : " + usableSpace + "GB");
            System.out.println("여유 디스크 용량 : " + freeSpace + "GB");
            System.out.println("사용한 디스크 용량 : " + usedSpace+"GB");
            System.out.println();            
        }
    } 

}
