package edu.cs.tcu.tcustartalkproject.Chapter;
import java.io.Serializable;

/**
 * Class for special pinyin.
 * Normally, pinyin is pre-defined in CCCEdict. Customized Pinyin is only created
 * if the user desires.
 */

public class Pinyin implements Serializable {
    private String id;
    private String pinyin;

    /**
     * Constructor for Pinyin without arguments
     */
    public Pinyin() {
        super();
    }

    /**
     * Get id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get pinyin.
     * @return pinyin
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * Set pinyin
     * @param pinyin pinyin
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

}
