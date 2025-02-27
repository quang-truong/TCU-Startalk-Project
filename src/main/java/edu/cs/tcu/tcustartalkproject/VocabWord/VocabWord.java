package edu.cs.tcu.tcustartalkproject.VocabWord;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Document(collection= "VocabWord")
public class VocabWord implements Serializable {
    @Id
    private String id;
    private String pinyin;
    private String desc;

    public VocabWord() {
    }

    /**
     * Constructor for Vocab Word objects with arguments
     * @param id index in database
     * @param word the Vocab Word itself
     * @param desc brief description of the vocab word
     */
    public VocabWord(String id, String type, String word, String pinyin, String desc){
        this.id = id;
        this.pinyin = pinyin;
        this.desc = desc;
    }

    public VocabWord(String id) {
        this.id = id;
    }

    /**
     * Method to get index of the vocab word in the database
     * @return index of the vocab word
     */
    public String getId() {
        return id;
    }

    /**
     * Method to set index of the vocab word in the database
     * @param id index to be set in the database
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method to get description of the vocab word in the database
     * @return description of the vocab word in the database
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Method to set description of the vocab word in the database
     * @param desc description to be set in the database
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Method to get pinyin of the vocab word in the database
     * @return pinyin of the vocab word in the database
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * Method to set pinyin of the vocab word in the database
     * @param pinyin of the vocab word in the database
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}