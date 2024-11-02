package com.polstat.perpustakaan.rpc;

import com.polstat.perpustakaan.dto.BookDto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class JsonRpcResponse {
    private String jsonrpc;
    private Object result;
    private Object error;
    private String id;

    public JsonRpcResponse(List<BookDto> books, String id) {
        this.result = books;
        this.id = id;
    }
    public JsonRpcResponse(String jsonrpc, String id) {
        this.result = jsonrpc;
        this.id = id;
    }
}
