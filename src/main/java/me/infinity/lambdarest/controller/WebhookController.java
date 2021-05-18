package me.infinity.lambdarest.controller;

import club.minnced.discord.webhook.WebhookClient;
import me.infinity.lambdarest.entity.BotVote;
import me.infinity.lambdarest.entity.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WebhookController {
    private final Logger LOGGER = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping(
            value = "/topgg",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    Response postWebhook(@RequestBody BotVote vote, HttpServletRequest request) {
        if (request.getHeader("Authorization").equals(System.getenv("TOKEN"))) {
            final String user = vote.getUser();
            final String bot = vote.getBot();
            if (vote.getType().equals("upvote"))
                WebhookClient.withUrl(System.getenv("VOTE_WEBHOOK")).send(String.format("%s voted %s", user, bot));
            else if(vote.getType().equals("test"))
                WebhookClient.withUrl(System.getenv("VOTE_WEBHOOK")).send("TEST Successful");

            LOGGER.info("Successfully got request and sent msg");
            return new Response(true, 200, "Success");
        }

        return new Response(false, 401, "Unauthorized");
    }

}
