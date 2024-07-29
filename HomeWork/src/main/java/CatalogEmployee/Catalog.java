package CatalogEmployee;

import java.util.*;

public class Catalog {
    private List<Employee> catalog = new ArrayList<>();

    public List<Employee> findByExperience(int exp){
        List<Employee> result = catalog.stream().filter(e -> e.getExperience() == exp).toList();

        return result;
    }

    public List<String> findPhonesByName(String name){
        List<Employee> employees = catalog.stream().filter(e -> e.getName().equals(name)).toList();

        List<String> phones = new ArrayList<>();

        employees.forEach(employee -> {
            phones.add(employee.getPhone());
        });

        return phones;
    }

    public Employee findByTabelNumber(int tabelNumber){
        for (Employee employee : catalog) {
            if (employee.getTabelNumber() == tabelNumber) return employee;
        }

        return null;
    }

    public void add(){
        Scanner scanner = new Scanner(System.in);

        catalog.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getTabelNumber() - o2.getTabelNumber();
            }
        });

        int newTabelNumber = catalog.get(catalog.size() - 1).getTabelNumber() + 1;

        Employee employee = new Employee();

        System.out.print("Введите имя: ");
        employee.setName(scanner.nextLine());

        System.out.print("Введите телефон: ");
        employee.setPhone(scanner.nextLine());

        System.out.print("Введите стаж: ");
        employee.setExperience(scanner.nextInt());

        employee.setTabelNumber(newTabelNumber);

        catalog.add(employee);

        System.out.println("Новый сотрудник сохранен с табельным номером: " + newTabelNumber);
    }
}
