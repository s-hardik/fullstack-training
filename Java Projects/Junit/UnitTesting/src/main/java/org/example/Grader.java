package org.example;

public class Grader {
    public char determineLetterGrade(int num){
        if(num<0){
            throw new IllegalArgumentException("Number Grade Can not be less than 0");
        } else if (num<60) {
            return 'F';
        } else if (num<70) {
            return 'D';
        } else if (num<80) {
            return 'C';
        } else if (num<90) {
            return 'B';
        }
        else {
            return 'A';
        }
    }
}
