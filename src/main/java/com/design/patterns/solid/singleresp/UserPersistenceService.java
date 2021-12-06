package com.design.patterns.solid.singleresp;

public class UserPersistenceService {

    private Store store = new Store();

    public void persist(User user) {
        store.store(user);
    }
}
