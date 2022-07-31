package restaurante.waiter.commands;

import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

public class updateWaiterPhoneNumber {
    private final Waiter_ID waiter_id;
    private final PhoneNumber phoneNumber;

    public updateWaiterPhoneNumber(Waiter_ID waiter_id, PhoneNumber phoneNumber) {
        this.waiter_id = waiter_id;
        this.phoneNumber = phoneNumber;
    }

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
