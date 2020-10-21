package com.example.myapplication.UnitTests;

import com.example.myapplication.model.Message;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class MessageTests {
    @Test
    public void StandardInitialisation() {
        Message result = new Message();
        assertThat(result, instanceOf(Message.class));
        assertNotNull(result);
    }

    //init with specific id

    @Test
    public void InitialisationUUID() {
        UUID input =UUID.randomUUID();

        Message result = new Message(input);

        assertThat(result, instanceOf(Message.class));
        assertNotNull(result);
        assertSame(input,result.getId());
    }
}