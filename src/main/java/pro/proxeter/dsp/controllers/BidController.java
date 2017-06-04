package com.propellerads.rtb.dsp.controllers;

import com.propellerads.rtb.dsp.models.Bid;
import com.propellerads.rtb.dsp.services.DSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by proxeter on 04.06.17.
 */
@RestController
@RequestMapping("/bid")
public class BidController
{
    @Autowired
    private DSPService dspService;

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<?> getBidFormattedJson(
            @RequestParam("price") float price,
            @RequestParam("url") String url,
            @RequestParam("wait") int wait
            )
    {
        dspService.shouldWait(wait);

        Bid bid = new Bid().withUrl(url).withPrice(price);
        return ResponseEntity.ok(bid);
    }

    @RequestMapping(value = "/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, headers = "Accept=application/xml")
    public @ResponseBody ResponseEntity<?> getBidFormattedXML(
            @RequestParam("price") float price,
            @RequestParam("url") String url,
            @RequestParam("wait") int wait
    )
    {
        dspService.shouldWait(wait);

        Bid bid = new Bid().withUrl(url).withPrice(price);
        return ResponseEntity.ok(bid);
    }

    @RequestMapping(value = "/random/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<?> getRandomBidFormattedJson() {
        return ResponseEntity.ok(new Bid().withRandom());
    }

    @RequestMapping(value = "/random/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, headers = "Accept=application/xml")
    @ResponseBody
    public ResponseEntity<?> getRandomBidFormattedXML() {
        return ResponseEntity.ok(new Bid().withRandom());
    }
}
