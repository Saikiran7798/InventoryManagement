package com.Assignment.InventoryManagement.ExceptionHandler;

public class CustomExceptions {

    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }

    public static class ItemNotAvailableException extends RuntimeException {
        public ItemNotAvailableException(String message) {
            super(message);
        }
    }

    public static class EmptyLowCountException extends RuntimeException {
        public EmptyLowCountException(String message) {
            super(message);
        }
    }
}
