package hello;

import java.util.Arrays;

//import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GsSpringBootDockerApplication {

	@Value("${person.name}")
	private String name;
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/")
    public String home() {
		System.out.println("Service called. Hello Docker World..." + name + ", port=" + port);
        return "Hello Docker World....." + name + ", port=" + port; 
    }
	
	/*@RequestMapping(value = "/getVideoFSR/{videoName}", method = RequestMethod.GET)
	@ResponseBody public FileSystemResource getVideoFSR(@PathVariable("videoName") String videoName, HttpServletResponse response) {
	    String path = "D:\\Proposals\\WorkWear\\Documents\\SampleVideos\\" + videoName+".mp4";
	    return new FileSystemResource(path);
	}*/
	
	/*@RequestMapping(value = "/getVideoIOU/{videoName}", method = RequestMethod.GET)
	@ResponseBody public void getVideoIOU(@PathVariable("videoName") String videoName, HttpServletResponse response) {
	    try {
	    	String path = "D:\\Proposals\\WorkWear\\Documents\\SampleVideos\\" + videoName+".mp4";
	        File file = new File(path);
	        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
	        response.setHeader("Content-Disposition", "attachment; filename="+file.getName().replace(" ", "_"));
	        InputStream iStream = new FileInputStream(file);
	        IOUtils.copy(iStream, response.getOutputStream());
	        response.flushBuffer();
	    } catch (java.nio.file.NoSuchFileException e) {
	        response.setStatus(HttpStatus.NOT_FOUND.value());
	    } catch (Exception e) {
	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    }
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(GsSpringBootDockerApplication.class, args);
	}
	
	public void run(ApplicationArguments args) throws Exception { 
		System.out.println("Application started with command line arguments: " + Arrays.toString(args.getSourceArgs()));
		System.out.println("Application started with command line arguments: " + args.getNonOptionArgs());
		System.out.println("Application started with command line arguments: " + args.getOptionNames());
		
		for(String name: args.getOptionNames()) {
			System.out.println("arg-"+name+"="+args.getOptionValues(name));
		}
		
		boolean containsOption = args.containsOption("person.name");
		System.out.println("Contains person.name: " + containsOption);
	}
}
