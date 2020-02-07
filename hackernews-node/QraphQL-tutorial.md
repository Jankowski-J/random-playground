GraphQL
- new API standard
- declarative data fetching
- single endpoint on server side

- minimizes data needed to fetch via network
- no over- and underfetching (multiple requests to execute)
- since the clients fetch only needed data, I can monitor which data is really needed

- schema: contract between client and server
-- SDL: Schema Definition Language

- mutations
-- creating new data
-- updating existing data
-- deleting existing data

- subscriptions - event system

- resolver - a function responsible for fecthing a specified field


REST:
- unneeded data fetched via the endpoint