package model;

import java.util.Date;

/**
 *  Class for data about Dragon
 *
 */
public class Dragon {

    private Integer id;
    private String name;
    private Sex sex;
    private Date birth;
    private int strength;
    private int agility;
    private int intelligence;
    private int vitality;
    private int luck;

    public Dragon() {
    }

    public Dragon (String name, Sex sex) {
        this.name = name;
        this.sex = sex;
        birth = new Date();
    }

    public Dragon(Integer id, String name, Sex sex, Date birth) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 0 for MALE dragon, 1 for FEMALE dragon
     */
    public boolean getSex() {
        if (sex == Sex.MALE) return false;
        else return true;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}