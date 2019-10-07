package anesic;

import com.google.gson.annotations.SerializedName;

public class Berry{
    private int id;
    private String name;
    private int size;
    @SerializedName("growth_time") //I hope it's not a problem that I used something we didn't do in class
    private int growthTime;
    private String url;

    public Berry(){}

    public Berry(int id,String name,int size,int growthTime,String url){
        this.id = id;
        this.size = size;
        this.name = name;
        this.url = url;
        this.growthTime = growthTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Id: ")
                .append(getId())
                .append("\n")
                .append("Name: ")
                .append(getName())
                .append("\n")
                .append("Size: ")
                .append(getSize())
                .append("\n")
                .append("Growth Time: ")
                .append(getGrowthTime());
        return builder.toString();
    }

}
