package ee.mtiidla.headfirst.proxy;

class PersonImpl implements Person {

    private String name;
    private String gender;
    private String interests;
    private int hotOrNotRating;
    private int ratingCount;

    public PersonImpl(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        return ratingCount == 0 ? 0 : hotOrNotRating / ratingCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.hotOrNotRating += rating;
        this.ratingCount++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonImpl{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", interests='").append(interests).append('\'');
        sb.append(", hotOrNotRating=").append(hotOrNotRating);
        sb.append(", ratingCount=").append(ratingCount);
        sb.append('}');
        return sb.toString();
    }
}
