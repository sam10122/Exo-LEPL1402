import java.util.Optional;

public class OptionalTest {

    /**
     * Returns an Optional<TeamLeader> object from teamLeader
     */
    public Optional<TeamLeader> createOptionalTeamLeader(TeamLeader teamLeader) {
        return Optional.ofNullable(teamLeader);
    }

    /**
     * Increments the age of teamLeader by one
     */
    public void incAge(Optional<TeamLeader> optionalTeamLeader) {
       if(optionalTeamLeader.isPresent()){optionalTeamLeader.get().setAge(optionalTeamLeader.get().getAge()+1);}
    }

    /**
     * Increments the age of teamLeader by one only if its age is > 15
     */
    public void incAgeIfMoreThanFifteen(Optional<TeamLeader> optionalTeamLeader) {
        if(optionalTeamLeader.isPresent() && optionalTeamLeader.get().getAge() > 15){incAge(optionalTeamLeader);}
    }

    /**
     * Returns the name of the teamLeader or "No team leader"
     */
    public String getName(Optional<TeamLeader> optionalTeamLeader) {
        return (optionalTeamLeader.isPresent()) ? optionalTeamLeader.get().getName(): "No team leader";
    }

    /**
     * Returns the name of the teamLeader of the team of the person or "No team leader"
     */
    public String getNameOfTeamLeader(Optional<Person> optionalPerson) {
        return (optionalPerson.get().getTeam().get().getTeamLeader().isPresent()) ?
                optionalPerson.get().getTeam().get().getTeamLeader().get().getName() : "No team leader";
    }
}
