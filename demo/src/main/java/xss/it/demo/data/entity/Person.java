/*
 * Copyright © 2024. XTREME SOFTWARE SOLUTIONS
 *
 * All rights reserved. Unauthorized use, reproduction, or distribution
 * of this software or any portion of it is strictly prohibited and may
 * result in severe civil and criminal penalties. This code is the sole
 * proprietary of XTREME SOFTWARE SOLUTIONS.
 *
 * Commercialization, redistribution, and use without explicit permission
 * from XTREME SOFTWARE SOLUTIONS, are expressly forbidden.
 */

package xss.it.demo.data.entity;

import java.util.Objects;

/**
 * @author XDSSWAR
 * Created on 06/27/2024
 */
public final class Person {
    /**
     * The name of the user.
     */
    private String name;

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * The city associated with the user.
     */
    private String city;

    /**
     * The MAC address of the user's device.
     */
    private String mac;

    /**
     * The timestamp representing the record creation or update time.
     */
    private String timestamp;

    /**
     * The credit card number associated with the user.
     */
    private String creditCard;

    /**
     * Constructs a {@code Person} instance with the specified details.
     *
     * @param name       the name of the person
     * @param email      the email address of the person
     * @param city       the city associated with the person
     * @param mac        the MAC address of the person's device
     * @param timestamp  the timestamp representing record creation or update time
     * @param creditCard the credit card number associated with the person
     */
    public Person(String name, String email, String city, String mac, String timestamp, String creditCard) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.mac = mac;
        this.timestamp = timestamp;
        this.creditCard = creditCard;
    }

    /**
     * Gets the name of the person.
     *
     * @return the name as a {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the person.
     *
     * @return the email as a {@link String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person.
     *
     * @param email the new email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the city associated with the person.
     *
     * @return the city as a {@link String}
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city associated with the person.
     *
     * @param city the new city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the MAC address of the person's device.
     *
     * @return the MAC address as a {@link String}
     */
    public String getMac() {
        return mac;
    }

    /**
     * Sets the MAC address of the person's device.
     *
     * @param mac the new MAC address to set
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * Gets the timestamp representing record creation or update time.
     *
     * @return the timestamp as a {@link String}
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp representing record creation or update time.
     *
     * @param timestamp the new timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the credit card number associated with the person.
     *
     * @return the credit card number as a {@link String}
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the credit card number associated with the person.
     *
     * @param creditCard the new credit card number to set
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * Checks whether this {@code Person} instance is equal to another object.
     * Two instances are considered equal if they have the same name, email, city, MAC address,
     * timestamp, and credit card number.
     *
     * @param o the object to compare
     * @return {@code true} if the objects are equal, otherwise {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(name, person.name)
                && Objects.equals(email, person.email)
                && Objects.equals(city, person.city)
                && Objects.equals(mac, person.mac)
                && Objects.equals(timestamp, person.timestamp)
                && Objects.equals(creditCard, person.creditCard);
    }

    /**
     * Returns the hash code for this {@code Person} instance, based on its fields.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, email, city, mac, timestamp, creditCard);
    }

    /**
     * Returns a string representation of this {@code Person} instance.
     *
     * @return a {@link String} containing the person's details
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", mac='" + mac + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
