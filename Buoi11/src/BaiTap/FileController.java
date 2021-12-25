package BaiTap;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public void openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterWrite(String fileName) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFileToRead(String fileName){
        try {
            scanner = new Scanner(Paths.get(fileName));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead(String fileName){
        scanner.close();
    }

    public void writeAccountToFile(String fileName, Account account) {
        openFileToWrite(fileName);
        printWriter.println(
                account.getId() + "|" + account.getFullName() + "|" + account.getUsername() + "|" +
                account.getPassword() + "|" + account.getEmail() + "|" +  account.getPhone()+ "|" +
                account.getCreateAt()
        );
        closeFileAfterWrite(fileName);
    }

    public Account CreateAccountFromData(String data){
        String[] datas = data.split("\\|");
        Account account = new Account(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3],datas[4],datas[5],datas[6]);
        return account;
    }

    public List<Account> ReadAccountFromFile(String fileName) {
        openFileToRead((fileName));
        List<Account> accountList = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            Account account = CreateAccountFromData(data);
            accountList.add(account);
        }
        closeFileAfterRead(fileName);
        return accountList;
    }

    public void updateAccountInFile(String fileName, List<Account> accountList) {
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        openFileToWrite(fileName);
        for (Account account: accountList) {
            printWriter.println(
                            account.getId() + "|" + account.getFullName() + "|" + account.getUsername() + "|" +
                            account.getPassword() + "|" + account.getEmail() + "|" +  account.getPhone()+ "|" +
                            account.getCreateAt()
            );
        }
        closeFileAfterWrite(fileName);
    }
}
