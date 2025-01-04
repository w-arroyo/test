package com.example.primerEjemplo.controller;

import com.example.primerEjemplo.NameValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ControllerTest {


    @Mock
    private NameValidator nameValidator;
    @InjectMocks
    private Controller controller;


    @Test
    void testDevolverSaludo() throws Exception {
       Mockito.when(nameValidator.validate("pa")).thenReturn(true);
        String response =controller.devolverSaludo("pa");
        Assertions.assertThat(response).isEqualTo("otro mensaje guy: pa");
    }
    @Test
    void testDevolverSaludoFalse() throws  Exception{
        Mockito.when(nameValidator.validate("a")).thenReturn(false);
        Assertions.assertThatThrownBy(() -> controller.devolverSaludo("a"))
                .isInstanceOf(Exception.class)
                .hasMessage("INVALID");
    }
}
