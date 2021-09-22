package LeetcodeProblems;

public class ExtractJobDefinitionName {

    public static void main(String[] args) {
        String input = "JobDefinition://oracle/apps/ess/prc/pon/response/submit/SubmitResponseJob";
        System.out.println(input.substring(input.lastIndexOf('/') + 1, input.length()));
    }
}
