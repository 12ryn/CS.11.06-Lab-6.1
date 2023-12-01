import java.io.*;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        PrintStream ps = new PrintStream("AdventureTime.txt");

        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        ps.println("Challenge 1: " + challengeOneAnswer);

        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        ps.println("Challenge 2: " + challengeTwoAnswer);

        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        ps.println("Challenge 3: " + challengeThreeAnswer);

        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        ps.println("Challenge 4: " + challengeFourAnswer);

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {

        int count = 0;
        int[] array = readFile(fileName);

        for(int i = 1; i < array.length; i++){

            if (array[i] > array[i - 1]){

                    count++;

            }

        }

        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {

        int count = 0;
        int[] array = readFile(fileName);

        for(int i = 0; i < array.length - 3; i++){

            int current = array[i] + array[i + 1] + array[i + 2];
            int next = array[i + 1] + array[i + 2] + array[i + 3];

            if(next > current){

                count++;

            }

        }

        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {

        int depth = 0;
        int horizontal = 0;

        String[] array = readStringFile(fileName);

        for(int i = 0; i < array.length; i++) {

            if(array[i].charAt(0) == 'f') {

                horizontal += parseInt(array[i].substring(8));

            }

            else if(array[i].charAt(0) == 'd'){

                depth += parseInt(array[i].substring(5));

            }

            else if(array[i].charAt(0) == 'u'){

                depth -= parseInt(array[i].substring(3));

            }


        }

        return depth * horizontal;

    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {

        int aim = 0;
        int depth = 0;
        int horizontal = 0;

        String[] array = readStringFile(filename);

        for(int i = 0; i < array.length; i++) {

            if(array[i].charAt(0) == 'f') {

                horizontal += parseInt(array[i].substring(8));
                depth +=  parseInt(array[i].substring(8)) * aim;


            }

            else if(array[i].charAt(0) == 'd'){

                aim += parseInt(array[i].substring(5));

            }

            else if(array[i].charAt(0) == 'u'){

                aim -= parseInt(array[i].substring(3));

            }

        }

        return depth * horizontal;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    private static String[] readStringFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

}