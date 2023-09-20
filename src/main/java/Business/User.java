/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/**
 *
 * @author Khoapa
 */
import java.io.Serializable;

public record User(String getFirstName, String getLastName, String getEmail) implements Serializable {

}
