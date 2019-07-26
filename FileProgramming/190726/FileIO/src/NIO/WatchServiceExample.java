package NIO;

import java.awt.Frame;
import java.awt.TextArea;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;


public class WatchServiceExample extends Frame {
	
	class WatchServuceThread extends Thread {
		public void run() {
			try {
				WatchService watchService = FileSystems.getDefault().newWatchService();
				Path directory = Paths.get("C://test");
				directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);
						
				while (true) {
					WatchKey watchKey = watchService.take();
					List<WatchEvent<?>> list = watchKey.pollEvents();
					for ( WatchEvent<?> watchEvent : list) {
						Kind<?> kind = watchEvent.kind();
						Path path = (Path) watchEvent.context();
						
						if( kind == StandardWatchEventKinds.ENTRY_CREATE) {
							textArea.append("颇老 积己凳 -> " + path.getFileName() + "\n");
						} else if ( kind == StandardWatchEventKinds.ENTRY_DELETE) {
							textArea.append("颇老 昏力凳 -> " + path.getFileName() + "\n");
						}  else if ( kind == StandardWatchEventKinds.ENTRY_MODIFY) {
							textArea.append("颇老 荐沥凳 -> " + path.getFileName() + "\n");
						}  else if ( kind == StandardWatchEventKinds.OVERFLOW) {
						} 
					}
		boolean valid = watchKey.reset();
		if(!valid) {
			break;
		}
	}
}catch (Exception e) {
	e.printStackTrace();
			}
		}
	}
			
	TextArea textArea;
	
	public WatchServiceExample () {
		//BorderPane root = new BorderPane();
		this.setSize(500,300);
		textArea = new TextArea();
		textArea.setEditable(false);
		this.add(textArea);
		this.setTitle("WatchServiceExample");
		setVisible(true);
		WatchServuceThread wst = new WatchServuceThread();
		wst.start();
	
	}
			
	public static void main (String[] args) {
		new WatchServiceExample();
	}
}
