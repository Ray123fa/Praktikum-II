package com.example.calculator1.rpc;

public class JsonRpcResponse {
    private String jsonrpc;
    private double result;
    private Object error;
    private String id;

    public JsonRpcResponse(double result, String id) {
        this.result = result;
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}