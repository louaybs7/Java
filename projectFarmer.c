#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_WORKERS_PER_DAY 3

int getDayIndex(char *day)
{
    char *weekdays[] = {"Monday", "Wednesday", "Thursday"};
    int numWeekdays = sizeof(weekdays) / sizeof(weekdays[0]);

    for (int i = 0; i < numWeekdays; i++)
    {
        if (strcmp(day, weekdays[i]) == 0)
        {
            return i;
        }
    }

    return -1;
}
void printFileContents(char *fileName)
{
    FILE *file = fopen(fileName, "r");
    if (file == NULL)
    {
        printf("Failed to open file %s\n", fileName);
        return;
    }

    char currentLine[100];

    while (fgets(currentLine, 100, file) != NULL)
    {
        printf("%s", currentLine);
    }

    fclose(file);
}
void deleteLineFromFile(char *fileName, char *nameToDelete)
{
    FILE *file = fopen(fileName, "r");
    if (file == NULL)
    {
        printf("Failed to open file %s\n", fileName);
        return;
    }

    // Create a temporary file to write the modified contents
    FILE *tempFile = fopen("temp.txt", "w");
    if (tempFile == NULL)
    {
        printf("Failed to create temporary file\n");
        fclose(file);
        return;
    }

    char currentLine[100];
    int lineFound = 0;

    while (fgets(currentLine, 100, file) != NULL)
    {
        if (strstr(currentLine, nameToDelete) == currentLine)
        {
            lineFound = 1;
        }
        else
        {
            fprintf(tempFile, "%s", currentLine);
        }
    }

    fclose(file);
    fclose(tempFile);

    if (lineFound)
    {
        remove(fileName);
        rename("temp.txt", fileName);
        printf("Line with name '%s' deleted from file %s\n", nameToDelete, fileName);
    }
    else
    {
        remove("temp.txt");
        printf("Line with name '%s' not found in file %s\n", nameToDelete, fileName);
    }
}
void addWorkerToFile(char *fileName, char *workerName, char *day)
{
    FILE *file = fopen(fileName, "a");
    if (file == NULL)
    {
        printf("Failed to open file %s\n", fileName);
        return;
    }

    // Check if the worker is already present in the file
    char currentLine[100];
    while (fgets(currentLine, 100, file) != NULL)
    {
        if (strstr(currentLine, workerName) != NULL)
        {
            printf("Worker %s is already present in the file\n", workerName);
            fclose(file);
            return;
        }
    }

    // Add the new worker to the file
    fprintf(file, "%s %s\n", workerName, day);
    printf("Worker %s added to file %s\n", workerName, fileName);

    fclose(file);
}

int main()
{
    char fileName[] = "workers.txt";
    int choice;
    char name[100];
    char day[100];
    char lineToDelete[100];

    while (1)
    {
        printf("Enter your choice:\n0- Add new worker\n1- Delete worker name\n2- Print all workers\n3- Exit program\n4- Delete all workers\n");
        scanf("%d", &choice);
        getchar(); // consume the newline character left in the input buffer

        switch (choice)
        {
        case 0:

            printf("Enter worker name: ");
            fgets(name, 100, stdin);
            name[strcspn(name, "\n")] = 0; // remove the newline character at the end
            printf("Enter the days of the week separated by spaces (e.g. Monday Wednesday Thursday): ");
            fgets(day, 100, stdin);
            day[strcspn(day, "\n")] = 0; // remove the newline character at the end
            addWorkerToFile(fileName, name, day);
            break;
        case 1:
            printf("Enter worker name to delete: ");
            fgets(name, 100, stdin);
            name[strcspn(name, "\n")] = 0; // remove the newline character at the end
            deleteLineFromFile(fileName, name);

            break;
        case 2:
            printFileContents(fileName);
            break;
        case 3:
            exit(0);
            break;
        case 4:
            // Clear the contents of the file by opening it in write mode
            fclose(fopen(fileName, "w"));
            printf("All workers deleted from file %s\n", fileName);
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break;
        }
    }

    return 0;
}
