import java.util.*;
import java.io.*;

class Room implements Comparable<Room> {
    int time;
    char state;

    public Room(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Room e) {
        if (this.time == e.time) return this.state- e.state;
        return this.time - e.time;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            rooms.add(new Room(s, 's'));
            rooms.add(new Room(t, 'e'));
        }

        Collections.sort(rooms);
        int maxRoom = 0, current = 0;
        for (Room room : rooms) {
            if (room.state == 's') current++;
            else current--;
            maxRoom = Math.max(maxRoom, current);
        }

        System.out.println(maxRoom);
    }
}