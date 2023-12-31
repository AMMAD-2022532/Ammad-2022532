// Github link //
//  https://github.com/AMMAD-2022532/Ammad-2022532

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ammad.pkg2022532;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


/**
 *
 * @author me
 */


public class Ammad2022532 {

    public static class Team {
    private String name;
    private List<Person> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void addMember(Person person) {
        members.add(person);
    }

    @Override
    public String toString() {
        return "Team Name: " + name + ", Members: " + members;
    }
}

    public static class Person {
      private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getter methods for the attributes

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email;
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = System.getProperty("user.dir");
        System.out.println(s);
        String path = s+"/people.csv";
    List<Person> people = readDataFromFile(path);
        List<Team> teams = generateTeams(people, 20, 5);
        printTeams(teams);
    }

    private static List<Person> readDataFromFile(String filename) {
        List<Person> people = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String email = parts[3];
                    people.add(new Person(id, firstName, lastName, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    private static List<Team> generateTeams(List<Person> people, int numTeams, int teamSize) {
        List<Team> teams = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= numTeams; i++) {
            Team team = new Team("Team " + i);

            while (team.getMembers().size() < teamSize && !people.isEmpty()) {
                int randomIndex = random.nextInt(people.size());
                Person selectedPerson = people.get(randomIndex);
                team.addMember(selectedPerson);
                people.remove(randomIndex);
            }

            teams.add(team);
        }

        return teams;
    }

    private static void printTeams(List<Team> teams) {
        for (Team team : teams) {
            System.out.println(team);
        }
    }
}
    

