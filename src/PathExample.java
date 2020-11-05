import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\JCG\\articles\\Path\\file1.txt");
        System.out.println("Filename: " + path.getFileName());
        System.out.println("Name 0: " + path.getName(0));

        Path source = Paths.get("c:", "src","test","resources","solidity","file1.sol");
        System.out.println(source);
    }
}
