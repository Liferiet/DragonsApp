package dao;

import model.Dragon;
import util.C3poDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DragonDao {

    private int userId;

    public DragonDao(int userId) {
        this.userId = userId;
    }

    public boolean addDragon(Dragon dragon) {

        String sql = "INSERT INTO dragons (user_id, dragon_name, vitality, strength, agility, intelligence, luck, sex) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = C3poDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, dragon.getName());
            stmt.setInt(3, dragon.getVitality());
            stmt.setInt(4, dragon.getStrength());
            stmt.setInt(5, dragon.getAgility());
            stmt.setInt(6, dragon.getIntelligence());
            stmt.setInt(7, dragon.getLuck());
            stmt.setBoolean(8, dragon.getSex());

            int i = stmt.executeUpdate();
            if (i == 1) return true;

        } catch (SQLException e) {
            System.err.println("Problem with db, cannot add dragon");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDragon(Dragon dragon) {
        String sql = "DELETE FROM dragons WHERE dragon_id = ?";

        try (Connection connection = C3poDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dragon.getId());

            int i = stmt.executeUpdate();
            if (i == 1) return true;

        } catch (SQLException e) {
            System.err.println("Problem with db, cannot delete dragon");
            e.printStackTrace();
        }
        return false;
    }

    private boolean addStat(Dragon dragon, int currentStat, int valueToAdd, String stat) {

        String sql = "UPDATE dragons SET ? = ? WHERE user_id = ? && dragon_id = ?";
        try (Connection connection = C3poDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, stat);
            stmt.setInt(2, currentStat + valueToAdd);
            stmt.setInt(3, userId);
            stmt.setInt(4, dragon.getId());

            int i = stmt.executeUpdate();

            if (i == 1) return true;

        } catch (SQLException e) {
            System.err.println("Problem with db, cannot update dragon stat: " + stat);
            e.printStackTrace();
        }
        return false;
    }

    public boolean addVitality(Dragon dragon, int valueToAdd) {
        return addStat(dragon, dragon.getVitality(), valueToAdd, "vitality");
    }

    public boolean addAgility(Dragon dragon, int valueToAdd) {
        return addStat(dragon, dragon.getVitality(), valueToAdd, "agility");
    }

    public boolean addStrength(Dragon dragon, int valueToAdd) {
        return addStat(dragon, dragon.getVitality(), valueToAdd, "strength");
    }

    public boolean addIntelligence(Dragon dragon, int valueToAdd) {
        return addStat(dragon, dragon.getVitality(), valueToAdd, "intelligence");
    }

    public boolean addLuck(Dragon dragon, int valueToAdd) {
        return addStat(dragon, dragon.getVitality(), valueToAdd, "luck");
    }

}
