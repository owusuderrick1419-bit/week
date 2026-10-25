package src;
import java.util.Scanner;


public class CampusQuestCheckpointLab {

// Task B2.2 goes here

private static final int MIN_CHECKPOINT = 1;
private static final int MAX_CHECKPOINT =4;
private static final int SENTINEL = -1;
private static final int MIN_RESULT = 0;
private static final int MAX_RESULT =100;


    public static void main(String[] args) {
        // Create a scanner object
        Scanner input = new Scanner(System.in);
        System.out.println("Campus Quest Checkpoint Result Desk");

        // task B2.3 goes here
         System.out.print("Participant ID: ");
         String participantId = input.nextLine().trim().toUpperCase();

        System.out.print("Full name: ");
        String fullName = input.nextLine().trim();

        System.out.print("Challenge category (ACADEMIC/CODING/CREATIVE/WELLNESS): ");
        String challengeCategory = input.nextLine().trim().toUpperCase();

        System.out.print("Checkpoint number: ");
        int checkpointNumber = input.nextInt();
        input.nextLine(); 

        System.out.print("Session status (OPEN/CLOSED): ");
        String sessionStatus = input.nextLine().trim().toUpperCase();

        System.out.print("Wristband code (V/T/R): ");
        char wristbandCode = input.nextLine().trim().toUpperCase().charAt(0);

        System.out.print("Safety declaration accepted (true/false): ");
        boolean declarationAccepted = input.nextBoolean();
        input.nextLine(); 

        

       // task B2.4 goes here

            boolean idIsValid = participantId.length() == 5 && participantId.charAt(0) == 'P';


                // task B2.5 goes here
            if (idIsValid) { 
                for (int i = 1; i < participantId.length(); i++) {
                    char current = participantId.charAt(i);
                    if (!Character.isDigit(current)) { 
                    idIsValid = false;
           }
        }           
    }

            // task B2.7 goes here
            int assignedCheckpoint = switch (challengeCategory) {
                case "ACADEMIC" -> 1;
                case "CODING" -> 2;
                case "CREATIVE" -> 3;
                case "WELLNESS" -> 4;
                default -> SENTINEL;
            };
        
        // task B2.8 goes here
            boolean knownChallenge = assignedCheckpoint != SENTINEL;
            boolean checkpointInRange = checkpointNumber >= MIN_CHECKPOINT && checkpointNumber <= MAX_CHECKPOINT;
            boolean checkpointMatches = knownChallenge && checkpointNumber == assignedCheckpoint;
            boolean sessionOpen = sessionStatus.equals("OPEN");
            boolean wristbandVerified = wristbandCode == 'V';
            boolean isFullNameValid = !fullName.isEmpty();
    


        // task B2.9 goes here
            boolean deskReady = true;

            if (!idIsValid) {
                System.out.println("Invalid participant identifier");
                deskReady = false;
            } else if (!isFullNameValid) {
    System.out.println("Full name is blank");
    deskReady = false;
            } else if (!knownChallenge) {
                System.out.println("Unknown challenge category");
                deskReady = false;
            } else if (!checkpointInRange) {
                 System.out.println("Checkpoint number out of range");
                 deskReady = false;
            } else if (!checkpointMatches) {
                 System.out.println("Checkpoint does not match challenge");
                 deskReady = false;
            } else if (!sessionOpen) {
                 System.out.println("Session is not open");
                 deskReady = false;
            } else if (!wristbandVerified) {
                 System.out.println("Wristband is not verified");
                 deskReady = false;
            } else if (!declarationAccepted) {
                 System.out.println("Safety declaration not accepted");
                 deskReady = false;
            }

            if(deskReady){
           // task B3.1 goes here
     
                char confirmation;
                do {
                System.out.print("Confirm challenge (Y/N): ");
                confirmation = input.nextLine().trim().toUpperCase().charAt(0);
                if (confirmation != 'Y' && confirmation != 'N') {
                    System.out.println("Enter Y or N only.");
                }
            } while (confirmation != 'Y' && confirmation != 'N');

           // task B4.1 goes here
            int validCount = 0;
            int total = 0;
            int highest = SENTINEL;

            System.out.print("Enter raw results (Enter -1 to finish): ");
            int rawResult = input.nextInt();

            while (rawResult != SENTINEL) {
                if (rawResult >= MIN_RESULT && rawResult <= MAX_RESULT) {
                    validCount++;
                    total += rawResult;
                    highest = Math.max(highest, rawResult);
                } else {
                    System.out.println("Invalid result excluded.");
                 }
                 System.out.print("Enter raw results (Enter -1 to finish): ");
                 rawResult = input.nextInt();
            }
            input.nextLine(); // consume leftover newline after the last nextInt()

           // task B5.1 goes here
            String idDigits = participantId.substring(1);
            char participantInitial = Character.toUpperCase(fullName.trim().charAt(0));
            String safeName = fullName.trim().replace(" ", "-");

            String challengeLabel = switch (challengeCategory) {
                 case "ACADEMIC" -> "Academic Quest";
                 case "CODING" -> "Coding Quest";
                 case "CREATIVE" -> "Creative Quest";
                 case "WELLNESS" -> "Wellness Quest";
                 default -> "Unknown Challenge";
            };

            String resultLabel = "CP" + checkpointNumber + "-" + participantInitial + "-"
                    + idDigits + "-" + safeName + "-" + challengeLabel.toUpperCase();
            System.out.println("Result label: " + resultLabel);

           // task B6.1 goes here
            if (validCount == 0) {
                System.out.println("No valid results recorded.");
            } else {
                 double average = (double) total / validCount;
                 double roundedAverage = Math.round(average * 10.0) / 10.0;

            String performanceBand;
            if (roundedAverage >= 80) {
                performanceBand = "MASTER";
            } else if (roundedAverage >= 60) {
                performanceBand = "EXPLORER";
            } else {
                performanceBand = "STARTER";
            }

        System.out.println("Valid results: " + validCount);
        System.out.println("Total: " + total);
        System.out.println("Average: " + roundedAverage);
        System.out.println("Highest: " + highest);
        System.out.println("Band: " + performanceBand);
    }
}


        
        // Close scanner object
  input.close();
    }
}

    

