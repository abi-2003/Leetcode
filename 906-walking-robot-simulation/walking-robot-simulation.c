long long generateKey(int x, int y) {
    return (long long)(x + 30000) * 60001 + (y + 30000);
}

bool checkObstacle(int x, int y, long long* hashSet, int hashSetSize) {
    long long key = generateKey(x, y);
    for (int i = 0; i < hashSetSize; i++) {
        if (hashSet[i] == key) {
            return true;
        }
    }
    return false;
}

int robotSim(int* commands, int commandsSize, int** obstacles, int obstaclesSize, int* obstaclesColSize) {
    int max_distance = 0;
    int current_distance = 0;

    int next_x = 0, next_y = 0;
    
    long long* obstacleSet = (long long*)malloc(obstaclesSize * sizeof(long long));
    for (int i = 0; i < obstaclesSize; ++i) {
        obstacleSet[i] = generateKey(obstacles[i][0], obstacles[i][1]);
    }

    int current_position[2] = {0, 0};
    int current_direction[2] = {0, 1};

    for (int i = 0; i < commandsSize; ++i) {
        if (commands[i] > 0) {
            for (int step = 0; step < commands[i]; ++step) {
                next_x = current_position[0] + current_direction[0];
                next_y = current_position[1] + current_direction[1];

                if (checkObstacle(next_x, next_y, obstacleSet, obstaclesSize)) {
                    break;
                } else {
                    current_position[0] = next_x;
                    current_position[1] = next_y;
                }

                current_distance = (current_position[0] * current_position[0]) + (current_position[1] * current_position[1]);
                if (current_distance > max_distance) {
                    max_distance = current_distance;
                }
            }
        } else if (commands[i] == -1) {
            int new_x = current_direction[1];
            current_direction[1] = -current_direction[0];
            current_direction[0] = new_x;
        } else if (commands[i] == -2) {
            int new_x = -current_direction[1];
            current_direction[1] = current_direction[0];
            current_direction[0] = new_x;
        }
    }

    free(obstacleSet);
    return max_distance;
}

