/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import java.io.Serializable;

/**
 *
 * @author Khoapa
 */
public record UserPreferences(HowDidYouHearAboutUs getHowDidYouHearAboutUs, boolean getLikeThat, boolean getLikeEmail, mailingChoice getMailingChoice) implements Serializable 
{
    public enum HowDidYouHearAboutUs
    {
        searchEngine,
        wordOfMouth,
        socialMedia,
        other
    }
    
    public enum mailingChoice
    {
        emailOrPostal,
        email,
        postal
    }
}



