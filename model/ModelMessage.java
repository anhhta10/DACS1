
package model;

/**
 *
 * @author anhth
 */
public class ModelMessage {
    private boolean success;
    private String msssage;

    public ModelMessage() {
    }

    public ModelMessage(boolean success, String msssage) {
        this.success = success;
        this.msssage = msssage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return msssage;
    }

    public void setMessage(String message) {
        this.msssage = message;
    }
}
