from threading import Thread
import psutil
import time


def monitor_network():
    while True:
        network_stats = psutil.net_io_counters(pernic=True)
        print("Network stats:")
        for x in network_stats:
            print(x, network_stats[x])
        time.sleep(15)


def main():
    print("Starting monitoring of machine...")
    isMonitoring = True

    monitoring_thread = Thread(target=monitor_network())
    monitoring_thread.start()

    while isMonitoring:
        print("Monitoring the machine. Enter q to exit.")
        user_input = input('')
        if len(user_input) > 0 and user_input.lower()[0] == 'q':
            print('Exiting.')
            isMonitoring = False
            monitoring_thread.join()
        else:
            print('Unrecognized command. Try again.')


if __name__ == "__main__":
    main()