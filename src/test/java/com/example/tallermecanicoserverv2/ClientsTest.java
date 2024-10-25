package com.example.tallermecanicoserverv2;

import com.example.tallermecanicoserverv2.DTO.ClientsInformation.ClientsDTO;
import com.example.tallermecanicoserverv2.Repositories.ClientsRepositories;
import com.example.tallermecanicoserverv2.Services.ClientsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClientsTest {

    @Mock
    private ClientsRepositories clientsRepositories;

    @InjectMocks
    private ClientsService clientsService;

    @Test
    public void testGetAllClients_WhenEmptyList() {
        // Arrange
        Mockito.when(clientsRepositories.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<ClientsDTO> result = clientsService.GetClients();

        // Assert
        assertNull(result); // Expect null when the list is empty
    }

    @Test
    public void testGetAllClients_WhenNonEmptyList() {
        // Arrange
        ClientsDTO client1 = new ClientsDTO(); // Initialize with actual data if necessary
        List<ClientsDTO> expectedList = List.of(client1);
        Mockito.when(clientsRepositories.findAll()).thenReturn(expectedList);
        // Act
        List<ClientsDTO> result = clientsService.GetClients();
        // Assert
        assertEquals(expectedList, result); // Expect the actual list when it has elements
    }

    @Test
    public void testSearchOneClient_MatchFound() {
        // Arrange
        ClientsDTO client1 = new ClientsDTO("claudio"); // Replace with appropriate constructor
        List<ClientsDTO> allClients = List.of(client1);

        Mockito.when(clientsRepositories.findAll()).thenReturn(allClients);

        // Act
        List<ClientsDTO> result = clientsService.SearchOneClient("John");

        // Assert
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

}
