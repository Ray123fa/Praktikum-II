package com.polstat.perpustakaan.rpc;

import com.polstat.perpustakaan.dto.BookDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JsonRpcResponse {
    private String jsonrpc;  // Always set to "2.0" for JSON-RPC 2.0
    private Object result;           // The result if the call was successful
    private Object error;            // The error if the call failed
    private String id;               // The ID must match the request ID

    public JsonRpcResponse(List<BookDto> books, String id) {
        this.result = books;
        this.id = id;
    }
    public JsonRpcResponse(String jsonrpc, String id) {
        this.result = jsonrpc;
        this.id = id;
    }
}
