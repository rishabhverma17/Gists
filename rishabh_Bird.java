package com.verma.rishabh;

public class Bird {
    private final int weight;
    private final String color;

    // Mark the Constructor as Private.
    private Bird(Builder builder){
        this.weight = builder.weight;
        this.color = builder.color;
    }

    // For providing immutability just provide getters and not setters.
    public int getWeight(){
        return this.weight;
    }

    public String getColor(){
        return this.color;
    }

    /* Crux of Builder Design pattern */
    public static class Builder{
        private int weight;
        private String color;

        public Builder setWeight(int weight){
            // Can add some sanity checks here
            this.weight = weight;
            return this;
        }

        public Builder setColor(String color){
            this.color = color;
            return this;
        }

        public Bird build(){
            return new Bird(this);
        }
    }
    @Override
    public String toString()
    {
        return "Color : "+this.color + " , Weight : " + this.weight;
    }
}
