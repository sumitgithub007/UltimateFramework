package com.fujitsu.core.factories;

import com.fujitsu.core.pages.BasePage;

import lombok.SneakyThrows;

/**
 * @author Sumit Goyal
 * @since 27/06/23 3:05 pm
 */

public class PageFactory {

    /**I will return the pageObject of class you give to me
     * @param <T>
     * @param pageClass
     * @return
     */
    @SneakyThrows
    public static <T extends BasePage> T createPage (Class<T> pageClass) {
        return pageClass.getDeclaredConstructor ()
            .newInstance ();
    }
}

