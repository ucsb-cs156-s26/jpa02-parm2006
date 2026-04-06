package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void test_equals_same_object_returns_true() {
        assertTrue(team.equals(team),".equals() -> True when a.equals(a)");
    }

    @Test
    public void test_equals_non_team_object_returns_false() {
        assertTrue(!team.equals(1),".equals() -> False when a.equals(not_team)");
    }

    @Test
    public void test_equals_team_with_other_team_same_members() {
        Team otherteam = new Team("test-team");
        otherteam.addMember("kyle");
        otherteam.addMember("bob");

        team.addMember("kyle");
        team.addMember("bob");

        assertTrue(team.equals(otherteam),".equals() same name same mebmbers should be true");
    }


    @Test
    public void test_equals_team_with_other_team_diff_members() {
        Team otherteam = new Team("team");
        otherteam.addMember("kyle");
        otherteam.addMember("bob");

        team.addMember("kyle");
        team.addMember("sharon");

        assertTrue(!team.equals(otherteam),".equals() same name diff mebmbers should be false");
    }

    @Test
    public void test_equals_team_with_other_team_same_members_diff_name() {
        Team otherteam = new Team("other_team");
        otherteam.addMember("kyle");
        otherteam.addMember("bob");

        team.addMember("kyle");
        team.addMember("sharon");

        assertTrue(!team.equals(otherteam),".equals() diff name same mebmbers should be false");
    }
    @Test
    public void test_equals_team_with_diff_team() {
        Team otherteam = new Team("other_team");
        otherteam.addMember("kyle");
        otherteam.addMember("bob");

        team.addMember("kyle");
        team.addMember("sharon");

        assertTrue(!team.equals(otherteam),".equals() diff name diff mebmbers should be false");
        //clear team members list
        team.setMembers(new java.util.ArrayList<String>());
    }


    @Test
    public void test_hashCode_same_info_returns_same_hashcode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }


    @Test
    public void test_hashCode_diff_info_returns_diff_hashcode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("bar");
        t2.addMember("foo");
        assertTrue(t1.hashCode() != t2.hashCode(),"hashcode should be different for different team info");
    }

    @Test
    public void test_hashcode_or_mutation_breaker(){
        
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
