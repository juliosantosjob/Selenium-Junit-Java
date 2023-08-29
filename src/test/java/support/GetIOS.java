package support;

public class GetIOS {
    private static String osName = System.getProperty("os.name").toLowerCase();
    private static String userDir = System.getProperty("user.dir");
    private static String pathSystem;

    public static String getPathDriver() {
        if (osName.contains("win")) {
            System.out.println("Operating System: Windows");
            pathSystem = userDir + "\\drivers\\wind\\chromedriver.exe";

        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            System.out.println("Operating System: Unix/Linux");
            pathSystem = userDir + "/usr/bin/chromedriver";

        } else if (osName.contains("mac")) {
            System.out.println("Operating System: macOS");
            pathSystem = userDir + "/drivers/mac/chromedriver";

        } else {
            System.out.println("Sistema Operacional não reconhecido");
        }
        return pathSystem;
    }
}