package dao;

/**
 *
 * @author Roman
 */
public class UserDAO {
    
    private int id;
    private String gamerName;
    private int numberOfLosses;
    private int numberOfVictories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }
    
}
