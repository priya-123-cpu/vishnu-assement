

    // Step 1: Create the Notification interface
    interface Notification {
        void notifyUser();
    }

// Step 2: Implement different types of notifications

    class EmailNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending an Email Notification...");
        }
    }

    class SMSNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending an SMS Notification...");
        }
    }

    class PushNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending a Push Notification...");
        }
    }

    // Step 3: Create the Factory class
    class NotificationFactory {

        // Factory method
        public Notification createNotification(String type) {
            if (type == null || type.isEmpty()) {
                return null;
            }

            switch (type.toLowerCase()) {
                case "email":
                    return new EmailNotification();

                case "sms":
                    return new SMSNotification();

                case "push":
                    return new PushNotification();

                default:
                    throw new IllegalArgumentException("Unknown notification type: " + type);
            }
        }
    }

    // Step 4: Test the Factory Design Pattern
    public class FactoryPatternDemo {
        public static void main(String[] args) {

            NotificationFactory factory = new NotificationFactory();

            Notification email = factory.createNotification("email");
            email.notifyUser();

            Notification sms = factory.createNotification("sms");
            sms.notifyUser();

            Notification push = factory.createNotification("push");
            push.notifyUser();
        }
    }




