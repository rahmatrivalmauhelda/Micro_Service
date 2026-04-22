package com.rahmat.auth.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Map<String, String> users = new HashMap<>();

    // ✅ REGISTER
    public void register(String username, String password) {
        if (users.containsKey(username)) {
            throw new RuntimeException("User sudah ada");
        }

        users.put(username, password);
        System.out.println("User berhasil didaftarkan: " + username);
    }

    // ✅ LOGIN (AMAN, TIDAK ERROR)
    public boolean login(String username, String password) {

        String storedPassword = users.get(username);

        // debug (opsional)
        System.out.println("Login attempt:");
        System.out.println("Username: " + username);
        System.out.println("Stored Password: " + storedPassword);

        return storedPassword != null && storedPassword.equals(password);
    }
}