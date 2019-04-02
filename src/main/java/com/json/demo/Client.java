package com.json.demo;

import com.json.demo.jsonstyle.JsonObject;
import com.json.demo.parser.Parser;
import com.json.demo.tokenizer.ReaderChar;
import com.json.demo.tokenizer.TokenList;
import com.json.demo.tokenizer.Tokenizer;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author yebin
 * @version 1.0
 * @className Client
 * @description 测试类
 * @date 2019/4/1 16:45
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        Tokenizer tokenizer = new Tokenizer();

        Parser parser = new Parser();
        String json = "{" +
                "\"hello\":\"1\"," +
                "\"world\":\"2\"" +
                "}";
        ReaderChar charReader = new ReaderChar(new StringReader(json));
        TokenList tokens = tokenizer.getTokenStream(charReader);
        JsonObject o = (JsonObject)parser.parse(tokens);
        System.out.println(o.get("hello"));
        System.out.println(o.toString());
    }
}
