import "./Authors.css";
export default function Authors({ authors }: { authors: Author[] }) {
    return (
        <div className="authors">
            <h1>Authors</h1>
            <ul>
                {authors.map((author) => (
                    <li key={author.id}>{`Name: (${author.name}) Surname: (${author.surname})  Id: (${author.id})`}</li>
                ))}
            </ul>
        </div>
    );
}