import java.io.InputStream;
import java.util.ArrayList;

public class CommandBuilder {

    public static void build (String pathdeel5, String indexName ,ArrayList<String> referencePathways){
        String refPathsJoined = String.join(",", referencePathways);

        try{
            String[] commandline = {
                    pathdeel5+"/bowtie2-build",
                    refPathsJoined,
                    pathdeel5+"/"+indexName
            };
            ProcessBuilder pb = new ProcessBuilder(commandline);
            Process proc = pb.start();
            InputStream is = proc.getInputStream();
            int c;
            while ((c = is.read()) != -1){
                System.out.print((char) c);
            }
            //TimeUnit.SECONDS.sleep(5);
            //System.out.println(proc.getOutputStream());
            //    proc.exitValue();
            //proc.destroy();

            //if (proc.waitFor() != 0)
            //   System.out.println("hier");
            // throw new  RuntimeException("error occured");
            //} catch (InterruptedException ex){
            //   System.out.println("interupt");
            //     Thread.currentThread().interrupt();
        }
        catch (Exception err) {

            err.printStackTrace();
            System.out.println("starcktrace");
            throw new RuntimeException(err);

        } finally {

        }
    }

    public static void mapSeparate (String pathdeel5, String indexName, String samName, ArrayList<String> readPathways1, ArrayList<String> readPathways2){
        String readPathways1Joined = String.join(",", readPathways1);
        String readPathways2Joined = String.join(",", readPathways2);

        try{
            String[] commandline = {
                    pathdeel5+"/bowtie2",
                    "-x",
                    pathdeel5+"/"+indexName,
                    "-1",
                    readPathways1Joined,
                    "-2", readPathways2Joined,

                    "-S",
                    pathdeel5+"/"+samName+".sam",
                    "--xeq"
                    //-x lambda -1 example/reads/reads_1.fq -2 example/reads/reads_2.fq -S lambda2.sam --xeq
            };
            ProcessBuilder pb2 = new ProcessBuilder(commandline);
            Process proc2 = pb2.start();
            InputStream inError = proc2.getErrorStream();
            //   InputStream is2 = proc2.getInputStream();
            int c2;

            while ((c2 = inError.read()) != -1) {
                System.out.print((char) c2);
            }

        }
        catch (Exception err) {

            err.printStackTrace();
            System.out.println("starcktracemap");
            throw new RuntimeException(err);

        } finally {

        }
    }

    public static void mapInterleaved (String pathdeel5, String indexName, String samName, ArrayList<String> readPathways1){
        String readPathways1Joined = String.join(",", readPathways1);


        try{
            String[] commandline = {
                    pathdeel5+"/bowtie2",
                    "-x",
                    pathdeel5+"/"+indexName,
                    "--interleaved",
                    readPathways1Joined,


                    "-S",
                    pathdeel5+"/"+samName+".sam",
                    "--xeq"
                    //-x lambda -1 example/reads/reads_1.fq -2 example/reads/reads_2.fq -S lambda2.sam --xeq
            };
            ProcessBuilder pb2 = new ProcessBuilder(commandline);
            Process proc2 = pb2.start();
            InputStream inError = proc2.getErrorStream();
            //   InputStream is2 = proc2.getInputStream();
            int c2;

            while ((c2 = inError.read()) != -1) {
                System.out.print((char) c2);
            }

        }
        catch (Exception err) {

            err.printStackTrace();
            System.out.println("starcktracemap");
            throw new RuntimeException(err);

        } finally {

        }
    }
}
