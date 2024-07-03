package com.example.tallermecanicoserverv2.Interfaces;


import com.example.tallermecanicoserverv2.DTO.Users.UsersDTO;

import java.util.List;

public interface IUsers {
    List<UsersDTO> GetUsers();
    List<UsersDTO> SearchOneUsers(String name);
    String AddUsers(UsersDTO user);
    UsersDTO UpdateUsers(UsersDTO update);
    String DeleteUsers(int id);
}
